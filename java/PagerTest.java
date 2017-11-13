public class PagerTest {

    public static void main(String[] args) {
        int total = 10;
        int size = 5;
        System.out.println("-------total:"+total+"---size:"+size+"------------");
        toRun(total, size);

        total = 10; size = 6;
        System.out.println("-------total:"+total+"---size:"+size+"------------");
        toRun(total, size);

        total = 10; size = 11;
        System.out.println("-------total:"+total+"---size:"+size+"------------");
        toRun(total, size);
    }

    public static void toRun(int total, int size) {
        for (int i = 1; i <= total; i++) {
            toPrint(Pager.pager(i, total, size));
        }
    }


    public static void toPrint(PagerVO vo) {
        for (PagerItemVO item: vo.getList()) {
            System.out.print(item.getType() == PagerItemVO.NUMBER_TYPE ? item.getNo() : vo.getEllipsis());
            System.out.print(item.isCurrent() ? "↑" : "");
            System.out.print("\t");
        }
        System.out.println();
    }
}
