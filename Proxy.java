public class Proxy{
    public static void main(String[] args){
        Ebook e1 = new ProxyEbook("space.pdf");
        Ebook e2 = new ProxyEbook("space2.pdf");
        Ebook e3 = new ProxyEbook("space.pdf");
        Ebook e4 = new ProxyEbook("space4.pdf");
        Ebook e5 = new ProxyEbook("space.pdf");

        e1.display();        
        e2.display();
        e3.display();
        e4.display();
        e5.display();

    }
}
interface Ebook{
    void display();
    String getTitle();
}
class RealEbook implements Ebook{
    private String filename;

    public RealEbook(String filename) {
        this.filename=filename;
        loadFromDisk();
    }
    private void loadFromDisk(){
        System.out.println("Ebook "+filename+" loaded from disk");
    }
    public void display(){
        System.out.println("File is "+filename);
    }
    public String getTitle(){
        return filename;
    }
}
class ProxyEbook implements Ebook{
    private RealEbook realEbook;
    private final String filename;
    public ProxyEbook(String filename){
        this.filename=filename;
    }
    public void display(){
        if (realEbook==null){
            realEbook = new RealEbook(filename);
        }
        realEbook.display();
    }
    public String getTitle(){
        return filename;
    }
}