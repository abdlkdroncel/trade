package trade.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.trade.dto.UserWalletRequest;
import trade.trade.entity.Share;
import trade.trade.entity.ShareIO;
import trade.trade.entity.UserInfo;
import trade.trade.entity.UserWallet;
import trade.trade.repository.UserWalletRepository;

import java.util.List;

@Service
public class UserWalletService {

    @Autowired private UserWalletRepository userWalletRepository;
    @Autowired private ShareService shareService;
    @Autowired private UserInfoService userInfoService;
    @Autowired private ShareIOService shareIOService;

    public void buy(UserWalletRequest request) throws Exception {
        Share share = shareService.getShareById(request.getShareId());
        if(share==null) throw new Exception("Share not found");
        UserInfo userInfo = userInfoService.getUserInfoById(request.getUserId());
        if(userInfo==null) throw new Exception("User not found");

        List<ShareIO> shareIOList = shareIOService.getShareIOByShareId(share.getId());
        int piece=0;
        piece=shareIOList.stream()
                .mapToInt(io -> io.getPiece() * io.getIo())
                .sum();
        if(piece>=request.getPiece()){
            updateWallet(request, share, userInfo,1);
        }else{
            throw new Exception("Buy process is fail");
        }

        updatePieceOfShare(share,request.getPiece(),-1);
    }

    public void sell(UserWalletRequest request) throws Exception {

        Share share = shareService.getShareById(request.getShareId());
        if(share==null) throw new Exception("Share not found");
        UserInfo userInfo = userInfoService.getUserInfoById(request.getUserId());
        if(userInfo==null) throw new Exception("User not found");

        List<UserWallet> userWalletList = getUserWalletsByUserInfoIdAndShareId(userInfo, share);
        int piece=0;
        piece=userWalletList.stream()
                .mapToInt(io -> io.getPiece() * io.getIo())
                .sum();
        if(piece>=request.getPiece()){
            updateWallet(request, share, userInfo,-1);
        }else{
            throw new Exception("Buy process is fail");
        }

        updatePieceOfShare(share,request.getPiece(),1);

    }

    public List<UserWallet> getUserWalletsByUserInfoIdAndShareId(UserInfo userInfo,Share share){
        return userWalletRepository.getUserWalletsByUserInfoIdAndShareId(userInfo.getId(),share.getId());
    }

    public void updatePieceOfShare(Share share, int piece, int i){
        ShareIO shareIO=new ShareIO();
        shareIO.setIo(i);
        shareIO.setShare(share);
        shareIO.setPiece(piece);
        shareIOService.onlySave(shareIO);
    }


    private void updateWallet(UserWalletRequest request, Share share, UserInfo userInfo,int i) {
        UserWallet userWallet=new UserWallet();
        userWallet.setPiece(request.getPiece());
        userWallet.setShare(share);
        userWallet.setUserInfo(userInfo);
        userWallet.setIo(i);
        userWalletRepository.save(userWallet);
    }
}
