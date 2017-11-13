public class PagerItemVO {
    public static final int NUMBER_TYPE = 1;
    public static final int ELLIPSIS_TYPE = 2;

    private int type;
    private int no;
    private boolean isCurrent;

    public PagerItemVO(int type, int no, boolean isCurrent) {
        this.type = type;
        this.no = no;
        this.isCurrent = isCurrent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}
