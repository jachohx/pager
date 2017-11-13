import java.util.ArrayList;
import java.util.List;

public class PagerVO {
    private int current;
    private int total;
    private int size;
    private String ellipsis;
    private List<PagerItemVO> list;

    public PagerVO(int current, int total, int size, String ellipsis){
        this.current = current;
        this.total = total;
        this.size = size;
        this.ellipsis = ellipsis;
        this.list = new ArrayList<PagerItemVO>(size);
    }

    public PagerVO addPageNo(int no, int type) {
        list.add(new PagerItemVO(type, no, type == PagerItemVO.NUMBER_TYPE && no == current));
        return this;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getEllipsis() {
        return ellipsis;
    }

    public void setEllipsis(String ellipsis) {
        this.ellipsis = ellipsis;
    }

    public List<PagerItemVO> getList() {
        return list;
    }
}
