package currentCode;

public enum tokenEnum {
    HAWK(0),
    BEAR(1),
    ELK(2),
    SALMON(3),
    FOX(4),
    EMPTY(5);
    int type;
    tokenEnum(int i) {
        this.type=i;
    }

}