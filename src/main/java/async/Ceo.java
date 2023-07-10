package async;

class Ceo {
  String id;
  String name;


  public Ceo(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String toString() {
    return "Ceo_" + name;
  }

  public String getId() {
    return id;
  }


  public String getName() {
    return name;
  }

}
