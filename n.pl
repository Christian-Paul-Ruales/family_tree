%Arbol Genealogico
%hombres
hombre(facundo_ruales).
hombre(jaime_ruales).
hombre(david_guachamin).
hombre(daniel_guachamin).
hombre(eduardo_ruales).
hombre(jorge_ruales).
hombre(christian_ruales).
hombre(jeremi_ruales).
hombre(alejandro_ruales).
hombre(jorge_oña).
hombre(ivan_oña). %tio
hombre(patricio_oña).
hombre(marlon_oña).
hombre(mateo_oña).

%mujeres
mujer(luz_vilaña).
mujer(teresa_ruales).
mujer(dolores_ruales).
mujer(marta_ruales).
mujer(alicia_ruales).
mujer(celia_ruales).
mujer(christina_guerrero).
mujer(victoria_ruales).
mujer(irene_betancourt).
mujer(fanny_oña).
mujer(beatriz_oña).
mujer(ana_oña).
mujer(mishel_oña).
mujer(veronica_oña).

%padre(X,Y) DONDE x es padre de y
padre(facundo_ruales,teresa_ruales).
padre(facundo_ruales,dolores_ruales).
padre(facundo_ruales,marta_ruales).
padre(facundo_ruales,alicia_ruales).
padre(facundo_ruales,celia_ruales).
padre(facundo_ruales,jaime_ruales).
padre(jaime_ruales,eduardo_ruales).
padre(jaime_ruales,jorge_ruales).
padre(jaime_ruales,christian_ruales).
padre(eduardo_ruales,jeremi_ruales).
padre(jorge_ruales,alejandro_ruales).
padre(jorge_ruales,victoria_ruales).
padre(jorge_oña,fanny_oña).
padre(jorge_oña,beatriz_oña).
padre(jorge_oña,ivan_oña).
padre(jorge_oña,ana_oña).
padre(jorge_oña,patricio_oña).
padre(ivan_oña,veronica_oña).
padre(ivan_oña,mishel_oña).
padre(patricio_oña,mateo_oña).

%Madre
madre(luz_vilaña,teresa_ruales).
madre(luz_vilaña,dolores_ruales).
madre(luz_vilaña,marta_ruales).
madre(luz_vilaña,alicia_ruales).
madre(luz_vilaña,celia_ruales).
madre(luz_vilaña,jaime_ruales).
madre(dolores_ruales,christina_guerrero).
madre(marta_ruales,david_guachamin).
madre(marta_ruales,daniel_guachamin).
madre(fanny_oña,eduardo_ruales).
madre(fanny_oña,jorge_ruales).
madre(fanny_oña,christian_ruales).
madre(irene_betancourt,fanny_oña).
madre(irene_betancourt,beatriz_oña).
madre(irene_betancourt,ivan_oña).
madre(irene_betancourt,ana_oña).
madre(irene_betancourt,patricio_oña).
madre(beatriz_oña,marlon_oña).
%hijo(x,y) X ES HIJO DE Y
hijo(X,Y):-(padre(Y,X);madre(Y,X)),hombre(X).
hija(X,Y):-(padre(Y,X);madre(Y,X)),mujer(X).
%parejas(x,y) donde x la/el espos@ de Y
esposo(facundo_ruales, luz_vilaña).
esposa(luz_vilaña, facundo_ruales).

esposo(jorge_oña, irene_betancourt).
esposa(irene_betancourt, jorge_oña).

esposo(jaime_ruales, fanny_oña).
esposa(fanny_oña, jaime_ruales).

%Hermanos x es hermano de y
hermano(X,Y):-((padre(Z,X),padre(Z,Y));(madre(W,X),madre(W,Y))),not(X=Y),hombre(X).
hermana(X,Y):-((padre(Z,X),padre(Z,Y));(madre(W,X),madre(W,Y))),not(X=Y),mujer(X).

%tios X es tio de Y ] medio raro esta
tio(X,Y):-(padre(W,Y);madre(W,Y)),hermano(X,W),hombre(X).
tia(X,Y):-(padre(W,Y);madre(W,Y)),hermana(X,W),mujer(X).
%casos especiales
tio(jaime_ruales,mateo_oña).
tio(jaime_ruales,marlon_oña).
tio(jaime_ruales,veronica_oña).
tio(jaime_ruales,mishel_oña).

tia(fanny_oña,david_guachamin).
tia(fanny_oña,daniel_guachamin).
tia(fanny_oña,christina_guerrero).

%x es sobrino de Y
sobrino(X,Y):- (tio(Y,X);tia(Y,X)),hombre(X).
sobrina(X,Y):- (tio(Y,X);tia(Y,X)),mujer(X).

%X ES ABUELO DE Y
abuelo(X,Y):-padre(X,W),(padre(W,Y);madre(W,Y)),hombre(X).
abuela(X,Y):-madre(X,W),(padre(W,Y);madre(W,Y)),mujer(X).

%x es nieto  de Y
nieto(X,Y):-(abuelo(Y,X);abuela(Y,X)), hombre(X).
nieta(X,Y):-(abuelo(Y,X);abuela(Y,X)), mujer(X).

% X ES PRIMO de Y
primo(X,Y):-hijo(X,W),(tio(W,Y);tia(W,Y)).
prima(X,Y):-hija(X,W),(tio(W,Y);tia(W,Y)).

% X ES BISABUELO DE Y
bisabuelo(X,Y):-padre(X,W),(abuelo(W,Y);abuela(W,Y)).
bisabuela(X,Y):-madre(X,W),(abuelo(W,Y);abuela(W,Y)).

%X ES CUÑADO DE Y
cun1(X,Y):-(esposo(Y,W);esposa(Y,W)),hermano(X,W).
cuna1(X,Y):-(esposo(Y,W);esposa(Y,W)),hermana(X,W).

cun2(X,Y):-(cun1(Y,X);cuna1(Y,X)), hombre(X).
cuna2(X,Y):-(cun1(Y,X);cuna1(Y,X)), mujer(X).

cunado(X,Y):-cun1(X,Y);cun2(X,Y).
cunada(X,Y):-cuna1(X,Y);cuna2(X,Y).