package Lesson_10;

public class Park {
    public static class Attractions {
        private String nameAttraction;
        private String openingHours;
        private float price;

        public Attractions(String nameAttraction, String openingHours, float price) {
            this.nameAttraction = nameAttraction;
            this.openingHours = openingHours;
            this.price = price;
        }

        public String getNameAttraction(){
            return nameAttraction;
        }

        public String getOpeningHours(){
            return openingHours;
        }

        public float getPrice(){
            return price;
        }
    }
}
