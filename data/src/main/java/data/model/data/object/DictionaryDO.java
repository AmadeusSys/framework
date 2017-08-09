package data.model.data.object;

/**
 * Created by TY on 2017/6/24.
 */
public class DictionaryDO {

    private String dict_id;

    private String dict_name;

    private String dict_type;

    private String dict_condition;

    public String getDict_id() {
        return dict_id;
    }

    public void setDict_id(String dict_id) {
        this.dict_id = dict_id;
    }

    public String getDict_name() {
        return dict_name;
    }

    public void setDict_name(String dict_name) {
        this.dict_name = dict_name;
    }

    public String getDict_type() {
        return dict_type;
    }

    public void setDict_type(String dict_type) {
        this.dict_type = dict_type;
    }

    public String getDict_condition() {
        return dict_condition;
    }

    public void setDict_condition(String dict_condition) {
        this.dict_condition = dict_condition;
    }

    public static DictionaryDO init(String type){
        DictionaryDO dictionaryDO = new DictionaryDO();
        dictionaryDO.setDict_type(type);
        return dictionaryDO;
    }

    @Override
    public String toString() {
        return "DictionaryDO{" +
                "dict_id='" + dict_id + '\'' +
                ", dict_name='" + dict_name + '\'' +
                ", dict_type='" + dict_type + '\'' +
                ", dict_condition='" + dict_condition + '\'' +
                '}';
    }
}
