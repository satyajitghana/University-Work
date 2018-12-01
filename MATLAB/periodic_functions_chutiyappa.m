%%syms x
%%fplot(myfunc(x), [0 2*pi])
x = linspace(0, 2*pi, 200);
%%y = myfunc(x);
%%plot(x, y)
x
disp(myfunc(x))

function y = myfunc(x)
    if x >= 0 & x < 2
        y = (-x+1);
    elseif x >= 2 & x < 4
        y = (x-3);
    end
end