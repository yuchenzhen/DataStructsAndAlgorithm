/**
 * 顺序表
 * size
 *
 */
public class SequenceList {
    private int size;
    private int maxSize;
    final int defaultSize = 10;
    Object[] list;

    SequenceList(int size) {
        this.size = 0;
        this.maxSize = size;
        this.list = new Object[size];
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    /**
     * 插入下标为 n 的位置
     * @param index
     * @param content
     */
    public void insert(int index, Object content) {
        if (index > this.size || index < 0) {
            throw new Error("超出顺序表范围");
        }
        if (this.size == this.maxSize) {
            throw new Error("顺序表已满");
        }

        for (int i = this.size; i > index; i-- ) {
            this.list[i] = this.list[i-1];
        }
        this.list[index] = content;
        this.size++;
    }

    public void delete (int index) {
        if (index > this.size || index < 0) {
            throw new Error("超出顺序表范围");
        }
        for (int i = index; i < this.size; i++) {
            this.list[i] = this.list[i+1];
        }
        this.size--;
    }

    public Object getList(int index) {
        if (index > this.size || index < 0) {
            throw new Error("超出顺序表范围");
        }
        return this.list[index];
    }

    public static void main (String[] args) {
        SequenceList hh = new SequenceList(10);
        System.out.println("SequenceList + :"+  hh.size);
        hh.insert(0, "hhh1");
        hh.insert(0, "hhh2");
        hh.insert(0, "hhh3");
        hh.insert(0, "hhh4");
        hh.delete(2);
        System.out.println("SequenceList + :"+  hh.list[0]);

    }
}