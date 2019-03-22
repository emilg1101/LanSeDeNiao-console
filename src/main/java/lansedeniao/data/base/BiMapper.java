package lansedeniao.data.base;

public interface BiMapper<F1, F2, T> {

    T map(F1 f1, F2 f2);
}
