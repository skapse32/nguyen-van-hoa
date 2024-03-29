package com.authenticate.ws;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.forgerock.opendj.ldap.Connection;
import org.forgerock.opendj.ldap.Entries;
import org.forgerock.opendj.ldap.Entry;
import org.forgerock.opendj.ldap.ErrorResultException;
import org.forgerock.opendj.ldap.LDAPConnectionFactory;
import org.forgerock.opendj.ldap.LinkedHashMapEntry;
import org.forgerock.opendj.ldap.TreeMapEntry;
import org.forgerock.opendj.ldap.requests.ModifyRequest;


@Produces("application/json")
@Path("/usermanager")
public class UserManagerResource {

	@POST
	@Path("/addUser")
	@Produces("application/json;")
	public String addUser(@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("fullname") String fullname,
			@FormParam("address") String address,
			@FormParam("telephoneNumber") String telephoneNumber,
			@FormParam("sex") boolean sex,
			@FormParam("birthday") String birthday,
			@FormParam("mail") String mail) throws UnsupportedEncodingException {
		Entry entry = new LinkedHashMapEntry("cn=" + username + ",ou=users,dc=springldap,dc=com")
				.addAttribute("cn", username)
				.addAttribute("sn", username)
				.addAttribute("uid", username)
				.addAttribute("objectclass", "myobjectclass")
				.addAttribute("userPassword", password)
				.addAttribute("fullname", URLDecoder.decode(fullname, "UTF-8"))
				.addAttribute("address",  URLDecoder.decode(address, "UTF-8"))
				.addAttribute("telephoneNumber", telephoneNumber)
				.addAttribute("sex", sex)
				.addAttribute("birthday", birthday)
				.addAttribute("mail", mail)
				.addAttribute("status", 1);

		final LDAPConnectionFactory factory = new LDAPConnectionFactory("localhost", 1389);
		Connection connection = null;
		try {
			connection = factory.getConnection();
			connection.bind("cn=Directory Manager", "123456".toCharArray());
			connection.add(entry);
			// Them user vao group
			entry = new LinkedHashMapEntry("cn=User,ou=groups,dc=springldap,dc=com");
			Entry old = TreeMapEntry.deepCopyOfEntry(entry);
			entry = entry.replaceAttribute("uniqueMember",
					"cn=" + username + ",ou=users,dc=springldap,dc=com");
			ModifyRequest request = Entries.diffEntries(old, entry);
			connection.modify(request);
		} catch (final ErrorResultException e) {
			return "error";
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		return "success";
	}
}
