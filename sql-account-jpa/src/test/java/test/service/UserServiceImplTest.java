/*
 * package test.service;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.hibernate.Session; import org.hibernate.SessionFactory; import
 * org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.ligarisma.dto.accountservices.User; import
 * com.ligarisma.entity.UserEntity;
 * 
 * 
 * //@RunWith(SpringJUnit4ClassRunner.class) //@ContextConfiguration(classes =
 * UserConfig.class, loader = AnnotationConfigContextLoader.class) public class
 * UserServiceImplTest { // // @Autowired // private UserService userService;
 * 
 * @Autowired private SessionFactory sessionFactory;
 * 
 * //@Test public void testDB(){ List<User> listUser = new ArrayList<User>();
 * 
 * Session session = sessionFactory.openSession(); // UserEntity userEntity =
 * new UserEntity(); List<UserEntity> userEntity = (List<UserEntity>)
 * session.createCriteria(UserEntity.class).list();
 * 
 * if (userEntity != null) { // user = userEntity.toDomain(User.class); for
 * (UserEntity s : userEntity) { listUser.add(s.toDomain(User.class)); } }
 * 
 * 
 * for(User u : listUser){ System.out.println(u.toString()); }
 * 
 * }
 * 
 * 
 * 
 * }
 */