package bookstore.domain;

import java.io.Serializable;

public abstract class DomainObject implements Serializable {
	private static final long serialVersionUID = 181914218243698482L;

	private long id;
	
	public DomainObject() {
		
	}
	
	public DomainObject(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}