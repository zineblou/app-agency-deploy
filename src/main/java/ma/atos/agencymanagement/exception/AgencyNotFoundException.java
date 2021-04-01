package ma.atos.agencymanagement.exception;

public class AgencyNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public AgencyNotFoundException(Long id){
        super("The Agency with "+ id +" cannot be found!");
    }
}
