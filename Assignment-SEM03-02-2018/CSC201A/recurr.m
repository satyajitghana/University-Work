function o = recurr(i)
%RECURR Summary of this function goes here
%   Detailed explanation goes here
C = [0.286223877779394 0.747586388319374 -0.335608049363139];
if i == 0
    o = 44;
elseif i == 1
    o = -3.87138;
elseif i == 2
    o = 16.4883;
elseif i == 3
    o = -12.9416;
else
    o = C(1)*recurr(i-1)+C(2)*recurr(i-2)+C(3)*recurr(i-3);
end
end

