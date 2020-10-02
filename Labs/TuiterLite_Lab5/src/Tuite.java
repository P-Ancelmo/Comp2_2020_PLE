import java.util.ArrayList;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private T anexo;
    private ArrayList<String> hashtags = new ArrayList<>();

    // hashtags?
    // objeto anexado?

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
        adicionaHashTag(texto.split("\\s"));
    }

    private void adicionaHashTag(String[] split){
        ArrayList<String> temp = new ArrayList<>();
        for(String s:split){

            if(s.startsWith("#") && !hashtags.contains(s)){
                hashtags.add(s);
            }
        }
    }

    public void anexarAlgo(T anexo) {
        this.anexo = anexo;
    }

    public T getAnexo() {
        return this.anexo;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    public ArrayList<Hashtag> getHashTags(){
        ArrayList<Hashtag> arrayHash = new ArrayList<>();
        for(String s : hashtags){
            arrayHash.add(new Hashtag(s));
        }
        return arrayHash;
    }
}
