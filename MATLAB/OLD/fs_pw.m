function[] = fs_pw(f1, f2, K, T, precision)
    syms x;
    w = (2*pi)/T;
    n = 1:K;
    
    %% calculate the constants
    a0 = (2/T)*(int(f1, x, 0, pi) + int(f2, x, pi, 2*pi));
    an = (2/T)*(int(f1*cos(n*w*x), x, 0, pi) + int(f2*cos(n*w*x), pi, 2*pi));
    bn = (2/T)*(int(f1*sin(n*w*x), x, 0, pi) + int(f2*sin(n*w*x), pi, 2*pi));
    v1 = [a0, an, bn];
    v2 = [1/2 cos(n*w*x) sin(n*w*x)];
    
    FS = v1.*v2;
    
    %% fouriere transform
    FS = sum(FS);
    FS = vpa(FS);
    
    disp('Fourier Transformed Equation : ');
    disp(FS);
    
    %%x = linspace(0, T, 500);
    %%y = eval(FS);
    %%plot(x, y, 'r');
    fplot(sym(FS), [0 4*pi], 'LineWidth', 2);
    hold on;
    
    g = @(x) f1(x).*(0<=x & x<pi)+f2(x).*(pi<=x & x<2*pi)
    x = linspace(0, 2*pi, 500);
    y = g(x);
    ry = repmat(y, 1, 3);
    rx = linspace(0, 6*pi, length(ry));

    plot(rx, ry, 'LineWidth', 2);
end