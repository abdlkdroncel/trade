package trade.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trade.trade.dto.ShareIORequest;
import trade.trade.entity.Share;
import trade.trade.entity.ShareIO;
import trade.trade.repository.ShareIORepository;

import java.util.List;

@Service
public class ShareIOService {

    @Autowired private ShareIORepository shareIORepository;
    @Autowired private ShareService shareService;

    public void save(ShareIORequest request) throws Exception {
        Share share = shareService.getShareById(request.getShareId());
        if(share==null) throw new Exception("Share not found");
        ShareIO shareIO=new ShareIO();
        shareIO.setShare(share);
        shareIO.setPiece(request.getPiece());
        shareIO.setIo(request.getIo());
        shareIORepository.save(shareIO);
    }

    public List<ShareIO> getShareIOByShareId(Long shareId){
        return shareIORepository.getShareIOByShareId(shareId);
    }

    public void onlySave(ShareIO shareIO){
        shareIORepository.save(shareIO);
    }
}
