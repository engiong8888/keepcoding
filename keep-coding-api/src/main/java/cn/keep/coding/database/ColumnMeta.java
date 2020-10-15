package cn.keep.coding.database;

/**
 * 列数据
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
public class ColumnMeta {

    /**
     * 字段名
     */
    private Object[] names;

    /**
     * 字段值
     */
    private Object[] values;

    public Object[] getNames() {
        return names;
    }

    public void setNames(Object[] names) {
        this.names = names;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
