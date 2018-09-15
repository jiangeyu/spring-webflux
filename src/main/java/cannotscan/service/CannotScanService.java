package cannotscan.service;

import org.springframework.stereotype.Service;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午4:08 2018/9/11
 * @desc
 */
@Service("cannotScanService")
public class CannotScanService {

    public CannotScanService() {
        System.out.println("this method cannot scan by spring boot if not user ImportResource");
    }
}
