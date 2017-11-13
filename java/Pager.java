public class Pager {

    private final static int LIST_MIN_SIZE = 5;

    public static PagerVO pager(int current, int total, int size) {
        return pager(current, total, size, "...");
    }

    public static PagerVO pager(int current, int total, int size, String ellipsis) {
        PagerVO pagerVO = new PagerVO(current, total, size, ellipsis);
        int currentNum = current;
        int maxNum = total;
        if (size < LIST_MIN_SIZE) size = LIST_MIN_SIZE;
        if (maxNum < size) size = maxNum;
        //页面全部填满
        if (size == maxNum){
            for (int i = 1; i <= size; i ++) {
                pagerVO.addPageNo(i, PagerItemVO.NUMBER_TYPE);
            }
        } else {
            int middleIdx = (int)Math.floor((size + 1) * 1.0 / 2.0);
            if (currentNum <= middleIdx){
                //左边填满，假设一共7个位置，如果中间的位置为4，那么页数只要小于4，那么前4个页数都是固定1 2 3 4
                //左边固定，那么右边就只剩下...跟最大页
                for (int i = 1; i <= (size - 2); i++) {
                    pagerVO.addPageNo(i, PagerItemVO.NUMBER_TYPE);
                }
                pagerVO.addPageNo(0, PagerItemVO.ELLIPSIS_TYPE);
                pagerVO.addPageNo(maxNum, PagerItemVO.NUMBER_TYPE);
            } else if (currentNum >= (maxNum - (size - middleIdx))) {
                //右边填满，右边的位置是最大页数-左边占的位置。
                //假设一共7个位置，最大页数是10，那么中间位置是4，那么右边占的位置只有3，再加上中间位置，那么只要在7 8 9 10这几页，则右边都会固定
                //右边固定，那么左边就只剩下1 ...
                pagerVO.addPageNo(1, PagerItemVO.NUMBER_TYPE);
                pagerVO.addPageNo(0, PagerItemVO.ELLIPSIS_TYPE);
                int start = maxNum - (size - 2) + 1;
                for (int i = start; i <= maxNum; i++) {
                    pagerVO.addPageNo(i, PagerItemVO.NUMBER_TYPE);
                }
            } else {
                //两边都没填满页数
                //前两个，后两个位置是固定 1 ... , ... n
                //假设一共7个位置，最大页数是10，那么中间位置是4，中间数为5，页数应该是1 ... 4 5 6 ... 10
                //那么最左两个是1 ... ，最右两个是 ... 10，剩下 7 - 4 = 3个位置未填满页数
                //那么就要计算其它未填的位置最开始的页数，即第3个位置
                //第3个位置，离中间位置差了 middle-2（1 ...），所以第3个位置的页数则为 5 - (4 - 2) + 1
                pagerVO.addPageNo(1, PagerItemVO.NUMBER_TYPE);
                pagerVO.addPageNo(0, PagerItemVO.ELLIPSIS_TYPE);
                int start = currentNum - (middleIdx - 2) + 1;
                for (int i = 0; i < (size - 4); i++) {
                    pagerVO.addPageNo(start + i, PagerItemVO.NUMBER_TYPE);
                }
                pagerVO.addPageNo(0, PagerItemVO.ELLIPSIS_TYPE);
                pagerVO.addPageNo(maxNum, PagerItemVO.NUMBER_TYPE);
            }
        }
        return pagerVO;
    }

}
