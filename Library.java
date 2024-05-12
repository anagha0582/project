import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Class definition
class Staff 
{
    private String name;
    private String designation;
    private String phoneNumber;

    public Staff(String name, String designation, String phoneNumber) 
    {
        this.name = name;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
    }

    public String getName() 
    {
        return name;
    }

    public String getDesignation() 
    {
        return designation;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }



    public Borrower registerBorrower(String name, int id, String phoneNumber, int age) 
    {
        System.out.println("Staff " + this.getName() + " is registering a new borrower.");
        if (age < 18) 
        {
            return new Student(name, id, phoneNumber, age, "School", 123);
        } 
        else 
        {
            return new Adult(name, id, phoneNumber, age, "ABCD1234");
        }
    }
}


class Borrower 
{
    private String name;
    private int id;
    private String phoneNumber;
    private int age;


    public Borrower(String name, int id, String phoneNumber, int age) 
    {
        this.name = name;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() 
    {
        return name;
    }

    public int getId() 
    {
        return id;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public int getAge() 
    {
        return age;
    }

    public void requestBook(Book book) 
    
    {
        System.out.println(this.getName() + " is requesting to borrow the book titled '" + book.getTitle() + "'.");
    }

    public void returnBook(Book book) 
    {
        System.out.println(this.getName() + " is returning the book titled '" + book.getTitle() + "'.");
    }
}

class Student extends Borrower 
{
    private String school;
    private int schoolId;

    public Student(String name, int id, String phoneNumber, int age, String school, int schoolId) 
    {
        super(name, id, phoneNumber, age);
        this.school = school;
        this.schoolId = schoolId;
    }

    public String getSchool() 
    {
        return school;
    }

    public int getSchoolId() 
    {
        return schoolId;
    }
}

class Adult extends Borrower 
{
    private String panCardId;

    public Adult(String name, int id, String phoneNumber, int age, String panCardId) 
    {
        super(name, id, phoneNumber, age);
        this.panCardId = panCardId;
    }

    public String getPanCardId() 
    {
        return panCardId;
    }
}

class Book 
{
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public Book(int bookId, String title, String author, String genre) 

    {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
    }

    public int getBookId() 
    {
        return bookId;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getGenre() 
    {
        return genre;
    }

    public boolean isAvailable() 
    {
        return available;
    }

    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
}

//class LibrarySystem {
   // private List<Book> books;

    //public LibrarySystem() {
       // this.books = new ArrayList<>();
   // }

   //  public void addBook(Book book) {
      //   books.add(book);
    // }

    // public Book findBook(String title) {
        // for (Book book : books) {
           //  if (book.getTitle().equals(title) && book.isAvailable()) {
              //   return book;
            // }
        // }
        // return null;
    // }


    public void borrowBook(Borrower borrower, Book book) 
    {
        if (book != null) {
            System.out.println("Library System: Book '" + book.getTitle() + "' borrowed by " + borrower.getName() + ".");
            book.setAvailable(false);
        } 
        else 
        {
            System.out.println("Library System: Book not found or unavailable.");
        }
    }

    public void returnBook(Borrower borrower, Book book) 
    {
        if (book != null) 
        {
            System.out.println("Library System: Book '" + book.getTitle() + "' returned by " + borrower.getName() + ".");
            book.setAvailable(true);
        } 
        else
         {
            System.out.println("Library System: Book not found.");
        }
    }
    class Borrow 
    {
    private int borrowerId;
    private int bookId;
    private Date issueDate;
    private Date returnDate;
    private String returnStatus;

    public Borrow(int borrowerId, int bookId, Date issueDate, Date returnDate, String returnStatus) 
    {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.returnStatus = returnStatus;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getReturnStatus() {
        return returnStatus;
    }
}

class Fine 
{
    private int borrowerId;
    private double amount;
    private String reason;

    public Fine(int borrowerId, double amount, String reason) 
    {
        this.borrowerId = borrowerId;
        this.amount = amount;
        this.reason = reason;
    }

    public int getBorrowerId() 
    {
        return borrowerId;
    }

    public double getAmount() 
    {
        return amount;
    }

    public String getReason() 
    {
        return reason;
    }
}
}

public class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creating staff
        Staff staff1 = new Staff("John Doe", "Librarian", "1234567890");
        Staff staff2 = new Staff("Alice Smith", "Assistant", "9876543210");
        Staff staff3 = new Staff("Bob Johnson", "Library Clerk", "5555555555");
        Staff staff4 = new Staff("Emily Brown", "Library Manager", "1111111111");
        Staff staff5 = new Staff("Michael Wilson", "Head Librarian", "2222222222");
        Staff staff6 = new Staff("Sarah Lee", "Library Assistant", "3333333333");

        // Creating library system
        //LibrarySystem librarySystem = new LibrarySystem();

        // Adding books to the library
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee", "Fiction");
        Book book2 = new Book(2, "1984", "George Orwell", "Science Fiction");
        Book book3 = new Book(3, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
        Book book4 = new Book(4, "Pride and Prejudice", "Jane Austen", "Romance");
        Book book5 = new Book(5, "The Catcher in the Rye", "J.D. Salinger", "Fiction");
        Book book6 = new Book(6, "Animal Farm", "George Orwell", "Satire");
        Book book7 = new Book(7, "Lord of the Flies", "William Golding", "Fiction");
        Book book8 = new Book(8, "The Hobbit", "J.R.R. Tolkien", "Fantasy");
        Book book9 = new Book(9, "The Alchemist", "Paulo Coelho", "Fantasy");
        Book book10 = new Book(10, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy");
        Book book11 = new Book(11, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy");
        Book book12 = new Book(12, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasy");
        Book book13 = new Book(13, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasy");
        Book book14 = new Book(14, "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasy");
        Book book15 = new Book(15, "Harry Potter and the Order of the Phoenix", "J.K. Rowling", "Fantasy");
        Book book16 = new Book(16, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasy");
        Book book17 = new Book(17, "Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasy");
        Book book18 = new Book(18, "The Da Vinci Code", "Dan Brown", "Mystery");
        Book book19 = new Book(19, "The Chronicles of Narnia", "C.S. Lewis", "Fantasy");
        Book book20 = new Book(20, "A Song of Ice and Fire", "George R.R. Martin", "Fantasy");
        Book book21 = new Book(21, "The Hunger Games", "Suzanne Collins", "Science Fiction");
        Book book22 = new Book(22, "The Girl with the Dragon Tattoo", "Stieg Larsson", "Mystery");
        Book book23 = new Book(23, "Gone with the Wind", "Margaret Mitchell", "Historical Fiction");
        Book book24 = new Book(24, "The Kite Runner", "Khaled Hosseini", "Historical Fiction");
        Book book25 = new Book(25, "The Martian", "Andy Weir", "Science Fiction");
        Book book26 = new Book(26, "Brave New World", "Aldous Huxley", "Science Fiction");
        Book book27 = new Book(27, "The Road", "Cormac McCarthy", "Dystopian Fiction");
        Book book28 = new Book(28, "Frankenstein", "Mary Shelley", "Gothic Fiction");
        Book book29 = new Book(29, "Dracula", "Bram Stoker", "Gothic Fiction");
        Book book30 = new Book(30, "The Picture of Dorian Gray", "Oscar Wilde", "Gothic Fiction");
        Book book31 = new Book(31, "Fahrenheit 451", "Ray Bradbury", "Science Fiction");
        Book book32 = new Book(32, "The Handmaid's Tale", "Margaret Atwood", "Dystopian Fiction");
        Book book33 = new Book(33, "One Hundred Years of Solitude", "Gabriel García Márquez", "Magical Realism");
        Book book34 = new Book(34, "Crime and Punishment", "Fyodor Dostoevsky", "Psychological Fiction");
        Book book35 = new Book(35, "The Brothers Karamazov", "Fyodor Dostoevsky", "Philosophical Fiction");
        Book book36 = new Book(36, "Moby-Dick", "Herman Melville", "Adventure");
        Book book37 = new Book(37, "The Adventures of Tom Sawyer", "Mark Twain", "Adventure");
        Book book38 = new Book(38, "Treasure Island", "Robert Louis Stevenson", "Adventure");
        Book book39 = new Book(39, "Wuthering Heights", "Emily Brontë", "Gothic Fiction");
        Book book40 = new Book(40, "Jane Eyre", "Charlotte Brontë", "Gothic Fiction");
        Book book41 = new Book(41, "Les Misérables", "Victor Hugo", "Historical Fiction");
        Book book42 = new Book(42, "The Count of Monte Cristo", "Alexandre Dumas", "Adventure");
        Book book43 = new Book(43, "War and Peace", "Leo Tolstoy", "Historical Fiction");
        Book book44 = new Book(44, "Anna Karenina", "Leo Tolstoy", "Romance");
        Book book45 = new Book(45, "The Odyssey", "Homer", "Epic Poetry");
        Book book46 = new Book(46, "The Iliad", "Homer", "Epic Poetry");
        Book book47 = new Book(47, "Don Quixote", "Miguel de Cervantes", "Adventure");
        Book book48 = new Book(48, "The Divine Comedy", "Dante Alighieri", "Epic Poetry");
        Book book49 = new Book(49, "The Metamorphosis", "Franz Kafka", "Absurdist Fiction");
        Book book50 = new Book(50, "The Stranger", "Albert Camus", "Existentialism");



        // Scenario 1: Staff Member Registers a New Borrower
        System.out.println("Enter borrower details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Borrower newBorrower = staff.registerBorrower(name, id, phoneNumber, age);
        System.out.println("New Borrower registered: " + newBorrower.getName());



        // Scenario 2: Borrower Requests to Borrow a Book
         System.out.println("Enter the title of the book you want to borrow:");
        String bookTitle = scanner.nextLine();

        Borrower borrower = newBorrower;
        Book requestedBook = librarySystem.findBook(bookTitle);

        if (requestedBook != null) 
        {
            borrower.requestBook(requestedBook);
            librarySystem.borrowBook(borrower, requestedBook);
        } 
        else 
        {
            System.out.println("Book not found or unavailable.");
        }

        // Scenario 3: Borrower Returns a Book
        public double returnBook(Borrower borrower, Book book, Date returnDate) {
        if (book != null) 
        {
            System.out.println("Library System: Book '" + book.getTitle() + "' returned by " + borrower.getName() + ".");
            book.setAvailable(true);

            Date issueDate = borrower.getIssueDate();
            long diffInMillies = Math.abs(returnDate.getTime() - issueDate.getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

            if (diffInDays > 0) 
            {
                System.out.println("Book returned " + diffInDays + " day(s) late.");
                double fineAmount = diffInDays * 7;
                System.out.println("Fine: Rs. " + fineAmount);
                return fineAmount;
            } 
            else 
            {
                System.out.println("Book returned on time. No fine charged.");
            }
        } 
        else 
        {
            System.out.println("Library System: Book not found.");
        }
        return 0;
    }
}