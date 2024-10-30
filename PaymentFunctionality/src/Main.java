// Main.java
public class Main {
  public static void main(String[] args) {
      DataLayer dataLayer = new DataLayer();
      BusinessLayer businessLayer = new BusinessLayer(dataLayer);
      PresentationLayer presentationLayer = new PresentationLayer(businessLayer);

      presentationLayer.startPaymentProcess();
  }
}
