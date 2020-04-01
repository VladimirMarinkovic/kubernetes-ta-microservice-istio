package vlada.spring.walterauthservice.exception;

public class KorisnikNijePronadjenException extends  RuntimeException {


    public KorisnikNijePronadjenException(String poruka) {
        super(poruka);
    }
}
