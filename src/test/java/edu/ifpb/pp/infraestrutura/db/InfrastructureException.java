package edu.ifpb.pp.infraestrutura.db;

/**
 * @since 17/11/2014
 * @version 1.0
 * @author Ricardo Job
 */
public class InfrastructureException extends RuntimeException {

    public InfrastructureException() {
    }

    public InfrastructureException(String message) {
        super(message);
    }

    public InfrastructureException(Throwable cause) {
        super(cause);
    }

    public InfrastructureException(String message, Throwable cause) {
        super(message, cause);
    }
}
