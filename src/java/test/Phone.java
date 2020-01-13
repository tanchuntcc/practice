package test;

class Phone{
        static  int l=1;

     public static synchronized void getIphone() throws InterruptedException{

    System.out.println("---------iphone");
    }
    public synchronized void getAndroid(){
     System.out.println("---------Android");
    }
    public void sayHello(){
        System.out.println("--------hello");
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        phone.getAndroid();
        phone1.getAndroid();
        try {
            Phone.getIphone();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}