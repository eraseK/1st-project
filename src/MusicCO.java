
public class MusicCO {
   private int num;
   private String name;
   private String singer;
   private String albulm;
   private String genre;
   private String id;
   
   
   
   public MusicCO() {
      super();
   }
   
   
   public MusicCO(int num, String name, String singer, String albulm, String genre) {
      super();
      this.num = num;
      this.name = name;
      this.singer = singer;
      this.albulm = albulm;
      this.genre = genre;
   }


   public MusicCO (int num,String name,String singer,String albulm,String genre,String id) {
   
      this.num = num;
      this.name = name;
      this.singer = singer;
      this.albulm = albulm;
      this.genre = genre;
      this.id = id;
   
   }
   public void setNum(int num) {
      this.num = num;
   }
   public void setName(String name) {
      this.name = name;
   }
   public void setSinger(String singer) {
      this.singer = singer;
   }
   public void setAlbulm(String albulm) {
      this.albulm = albulm;
   }
   public void setGenre(String genre) {
      this.genre = genre;
   }
   public void setId(String id) {
      this.id = id;
   }
   public int getNum() {
      return num;
   }
   public String getName() {
      return name;
   }
   public String getSinger() {
      return singer;
   }
   public String getAlbulm() {
      return albulm;
   }
   public String getGenre() {
      return genre;
   }
   public String getId() {
      return id;
   }


   @Override
   public String toString() {
      return "MusicCO [num=" + num + ", name=" + name + ", singer=" + singer + ", albulm=" + albulm + ", genre="
            + genre + ", id=" + id + "]";
   }
   
   
}