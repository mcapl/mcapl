dtmc

 module jpfModel
state : [0 ..38] init 0;
auavevade: bool init false;
auavland: bool init false;
pcollision: bool init false;
[] state = 0 -> 1.0:(state'=1) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 1 -> 1.0:(state'=2) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 2 -> 1.0:(state'=3) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 3 -> 1.0:(state'=4) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 4 -> 1.0:(state'=5) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 5 -> 1.0:(state'=6) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 6 -> 1.0:(state'=7) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 7 -> 1.0:(state'=8) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 8 -> 1.0:(state'=9) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 9 -> 1.0:(state'=10) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 10 -> 1.0:(state'=11) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 11 -> 1.0:(state'=12) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 12 -> 1.0:(state'=13) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 13 -> 1.0:(state'=14) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 14 -> 1.0:(state'=15) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 15 -> 1.0:(state'=16) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 16 -> 1.0:(state'=17) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 17 -> 1.0:(state'=18) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 18 -> 1.0:(state'=19) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 19 -> 1.0:(state'=20) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 20 -> 1.0:(state'=21) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 21 -> 1.0:(state'=22) & (auavevade'= false) & (auavland'= false) & (pcollision'= false);
[] state = 22 -> 1.0:(state'=23) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 23 -> 1.0:(state'=24) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 24 -> 1.0:(state'=25) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 25 -> 1.0:(state'=26) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 26 -> 1.0:(state'=27) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 27 -> 1.0:(state'=28) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 28 -> 1.0:(state'=29) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 29 -> 1.0:(state'=30) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 30 -> 1.0:(state'=31) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 31 -> 1.0:(state'=32) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 32 -> 1.0:(state'=33) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 33 -> 1.0:(state'=34) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 34 -> 1.0:(state'=35) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 35 -> 1.0:(state'=36) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 36 -> 1.0:(state'=37) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
[] state = 37 -> 1.0:(state'=38) & (auavevade'= false) & (auavland'= true) & (pcollision'= false);
endmodule