// Main.java
//The Main class serves as the entry point for the online pharmacy payment system application. It is responsible
// for initializing the various layers of the application, including DataLayer, BusinessLayer, and PresentationLayer.
// When the application starts, it creates instances of these layers and orchestrates the flow by calling the startPaymentProcess()
// method of the PresentationLayer. This triggers the payment interaction with the user, making it a crucial component for
// launching the application and ensuring that all parts work together seamlessly.






public class Main { // The main method that executes the application.
   
  public static void main(String[] args) {
      // Initialize the data layer to handle payment records
      DataLayer dataLayer = new DataLayer();
      
      // Initialize the business layer with a reference to the data layer
      BusinessLayer businessLayer = new BusinessLayer(dataLayer);
      
      // Initialize the presentation layer with a reference to the business layer
      PresentationLayer presentationLayer = new PresentationLayer(businessLayer);

      // Start the payment process, which prompts the user for payment details
      presentationLayer.startPaymentProcess();
  }
}
