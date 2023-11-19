package com.local.project.lesson20;


import java.security.cert.CertPathBuilder;
import java.util.List;

public class NutritionFacts {
        private int calories = -1;
        private int servings = -1;
        private int fat = -1;
        private int proteins = -1;
        private int carbs = -1;
        private String keyWords; // ewe, erew, trt,rqe

        private NutritionFacts(/*Builder builder*/) {
//            this.calories = builder.calories;
//            this.servings = builder.servings;
//            this.fat = builder.fat;
//            this.proteins = builder.proteins;
//            this.carbs = builder.carbs;
        }


        public static class Builder {
            private int calories;
            private int servings;
            private int fat;
            private int proteins;
            private int carbs;
            private List<String> keyWords;

            public Builder(int calories) {
                this.calories = calories;
            }
            public Builder servings (int servings) {
                this.servings = servings;
                return this;
            }
            public Builder fat (int fat) {
                this.fat = fat;
                return this;
            }
            public Builder proteins (int proteins) {
                this.proteins = proteins;
                return this;
            }

            public Builder carbs (int carbs) {
                this.carbs = carbs;
                return this;
            }


            public static void main(String[] args) {
                NutritionFacts milk = (NutritionFacts) new Builder(120)
                        .fat(10)
                        .build();

//                NutritionFacts meat = new NutritionFacts().
            }

            private NutritionFacts build() {
                if (calories < 1 || keyWords == null || keyWords.size() == 0 ){
                    throw new IllegalArgumentException("не установлены обязательные свойства");}
                NutritionFacts nf = new NutritionFacts();
                nf.servings = servings;
                nf.proteins = proteins;
                nf.calories = calories;
                nf.fat = fat;
                nf.carbs = carbs;
                nf.keyWords = String.join(", ", keyWords);

                return nf /*new NutritionFacts(this)*/;
            }

        }


}
