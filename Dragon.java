public class Dragon extends Cow{
    public Dragon(String name, String image) {
        super(name);
        this.image = image;
    }
    public boolean canBreatheFire() {
        return true;
    }
}
