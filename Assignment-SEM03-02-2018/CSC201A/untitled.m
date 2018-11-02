syms x
    f = tan(x);
    g = feval(symengine,'rewrite',f,'sincos')