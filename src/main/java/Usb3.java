public class Usb3 extends Usb2 implements Usb{
    @Override
    public void transfer() {
        System.out.println("快速传输");
    }
}
