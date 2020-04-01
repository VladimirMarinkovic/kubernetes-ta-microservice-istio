package vlada.spring.vozaciresourceserver.exception;

public class PrevoznikNijePronadjenException extends  RuntimeException {

    public PrevoznikNijePronadjenException(String poruka) { super(poruka); }
}
