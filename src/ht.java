import java.util.ArrayList;

public enum ht {// (habitatTypes
        Forest(0),
        Wetland(1),
        River(2),
        Mountain(3),
        Prairie(4);
        final int habitatNumber;
        ht(int i) {
                this.habitatNumber = i;
        }

        public int getHabitatNumber() {
                return habitatNumber;
        }
}
