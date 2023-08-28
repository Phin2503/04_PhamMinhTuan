package org.example;


    class News implements INews {
        private int ID;
        private String Title;
        private String PublishDate;
        private String Author;
        private String Content;
        private float AverageRate;
        private int[] Rates = new int[3];

        public News() {
        }

        public void setID(int id) {
            ID = id;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setPublishDate(String publishDate) {
            PublishDate = publishDate;
        }

        public void setAuthor(String author) {
            Author = author;
        }

        public void setContent(String content) {
            Content = content;
        }

        public void setRates(int[] rates) {
            Rates = rates;
        }

        public void setAverageRate(float averageRate) {
            AverageRate = averageRate;
        }

        public int getID() {
            return ID;
        }

        public String getTitle() {
            return Title;
        }

        public String getPublishDate() {
            return PublishDate;
        }

        public String getAuthor() {
            return Author;
        }

        public String getContent() {
            return Content;
        }

        public int[] getRates() {
            return Rates;
        }

        public float getAverageRate() {
            return AverageRate;
        }

        @Override
        public void display() {

        }

        @Override
        public void Display() {
            System.out.println("Title: " + Title);
            System.out.println("Publish Date: " + PublishDate);
            System.out.println("Author: " + Author);
            System.out.println("Content: " + Content);
            System.out.println("Average Rate: " + AverageRate);
        }



        @Override
        public float Calculate() {
            int sum = 0;
            for (int rate : Rates) {
                sum += rate;
            }
            AverageRate = (float) sum / Rates.length;
            return AverageRate;
        }
    }
