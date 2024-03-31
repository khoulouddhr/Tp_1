package ext;

import dao.IDao;

public class DaoImplVMS implements IDao {
    @Override
    public double getData() {
        System.out.println("version web service");
        return 0;
    }
}
