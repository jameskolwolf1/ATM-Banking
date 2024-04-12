import java.util.Objects;

public class Depositor {

    private Name name;
    private String socialSecurity;

    public Depositor(Name name, String socialSecurity) {
        this.name = name;
        this.socialSecurity = socialSecurity;
    }

    public Depositor(){}

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depositor depositor = (Depositor) o;
        return Objects.equals(name, depositor.name) && Objects.equals(socialSecurity, depositor.socialSecurity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, socialSecurity);
    }

    @Override
    public String toString() {

        String info = name.toString() + "\n";
        info = info + "Social Security: " + getSocialSecurity();
        return info;
    }
}
