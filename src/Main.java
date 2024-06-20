public class Main {
    public static class Book{
        String title = "Love Must Be Tough";
        String author = "DR. JAMES DOBSON";
        String type = "Gospel";
        int year = 1936;
        int ISBN = 1590523555;

        static class Title {
            static void summary(String t, String a) {
                System.out.println("Title: " + t + " by " + a);
            }
        }

        static class Others{
            static void stuff(int y, String typ, int IS){
                System.out.println("Type of book: " + typ + "\nYear: " + y + "\nISBN: " + IS);
            }
        }


    }


    public static void main(String[] args){
        Book obj = new Book();
        Book.Title.summary(obj.title, obj.author);
        Book.Others.stuff(obj.year, obj.type, obj.ISBN);
    }
}