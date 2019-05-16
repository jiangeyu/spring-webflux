package think.in.java.chapter14;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午1:04 2019/4/6
 * @desc
 */
public class AirFilter extends Part {

    public static class Factory implements think.in.java.chapter14.Factory<AirFilter> {

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
