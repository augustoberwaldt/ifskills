/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;

// TODO: Auto-generated Javadoc
public interface UserRepository extends CrudRepository<User, Long> {

	/**
	 * Find by email.
	 *
	 * @param email
	 *            the email
	 * @return the user
	 */
	User findByEmail(String email);
	
	/**
	 * @author: Aline G.	
	 * @date: 27/04/2016
	 * @description: Method to find a User by its FullName.
	 */
	User findByFullName(String fullname);
	
	/**
	 * @author Luciane
	 * @date: 11/05/2016
	 * @description: Method to find all by fuulName for User.
	 */
	List <User> findAllByFullName (String fullName);

	/**
	 * Find all by full name containing or email containing all ignore case.
	 *
	 * @param fullName
	 *            the full name
	 * @param email
	 *            the email
	 * @return the list
	 */
	List<User> findAllByFullNameContainingOrEmailContainingAllIgnoreCase(String fullName, String email);

	/**
	 * Find all by roles_ id.
	 *
	 * @param id
	 *            the id
	 * @return the list
	 */
	List<User> findAllByRoles_Id(Long id);

}