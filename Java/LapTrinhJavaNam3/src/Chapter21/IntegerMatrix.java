package Chapter21;

public class IntegerMatrix extends GenericMatrix<Integer>{

	@Override
	public Integer add(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1+o2;
	}

	@Override
	public Integer multiply(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1*o2;
	}

	@Override
	public Integer zero() {
		// TODO Auto-generated method stub
		return 0;
	}
}
