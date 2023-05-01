/*
Student Number - Name - Github ID
21467574 - Jack Wright - #102315833
21447182 - Jack Neilan - #102314039
21350866 - Trystan Rothery - #102313516
*/
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