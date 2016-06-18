bool bag1holdblock

active proctype JPFModel()
{
state0:
	bag1holdblock = true;
	if
	:: goto state1;
	:: goto state70;
	fi;
state1:
	bag1holdblock = true;
	if
	:: goto state2;
	:: goto state47;
	fi;
end_state2:
	bag1holdblock = false;
	printf("end state\n");
state2:
	bag1holdblock = true;
	if
	:: goto state3;
	:: goto state27;
	fi;
end_state3:
	bag1holdblock = false;
	printf("end state\n");
state3:
	bag1holdblock = true;
	if
	:: goto state16;
	:: goto state4;
	fi;
end_state4:
	bag1holdblock = false;
	printf("end state\n");
state4:
	bag1holdblock = true;
	if
	:: goto state5;
	:: goto state14;
	fi;
end_state5:
	bag1holdblock = false;
	printf("end state\n");
state5:
	bag1holdblock = true;
	goto state6;
end_state6:
	bag1holdblock = false;
	printf("end state\n");
state6:
	bag1holdblock = true;
	if
	:: goto state7;
	:: goto state11;
	fi;
end_state7:
	bag1holdblock = false;
	printf("end state\n");
state7:
	bag1holdblock = true;
	goto state8;
end_state8:
	bag1holdblock = false;
	printf("end state\n");
state8:
	bag1holdblock = false;
	goto state9;
end_state9:
	bag1holdblock = false;
	printf("end state\n");
state9:
	bag1holdblock = false;
	goto end_state2;
end_state10:
	bag1holdblock = false;
	printf("end state\n");
end_state11:
	bag1holdblock = false;
	printf("end state\n");
state11:
	bag1holdblock = false;
	goto state12;
end_state12:
	bag1holdblock = false;
	printf("end state\n");
state12:
	bag1holdblock = false;
	goto state13;
end_state13:
	bag1holdblock = false;
	printf("end state\n");
state13:
	bag1holdblock = false;
	goto end_state3;
end_state14:
	bag1holdblock = false;
	printf("end state\n");
state14:
	bag1holdblock = true;
	if
	:: goto state7;
	:: goto state15;
	fi;
end_state15:
	bag1holdblock = false;
	printf("end state\n");
state15:
	bag1holdblock = false;
	goto state12;
end_state16:
	bag1holdblock = false;
	printf("end state\n");
state16:
	bag1holdblock = true;
	if
	:: goto state17;
	:: goto state25;
	fi;
end_state17:
	bag1holdblock = false;
	printf("end state\n");
state17:
	bag1holdblock = true;
	goto state18;
state18:
	bag1holdblock = true;
	if
	:: goto state19;
	:: goto state22;
	fi;
state19:
	bag1holdblock = true;
	goto state20;
state20:
	bag1holdblock = false;
	goto state21;
state21:
	bag1holdblock = false;
	goto end_state4;
state22:
	bag1holdblock = false;
	goto state23;
state23:
	bag1holdblock = false;
	goto state24;
state24:
	bag1holdblock = false;
	goto end_state5;
state25:
	bag1holdblock = true;
	if
	:: goto state19;
	:: goto state26;
	fi;
state26:
	bag1holdblock = false;
	goto state23;
state27:
	bag1holdblock = true;
	if
	:: goto state39;
	:: goto state28;
	fi;
state28:
	bag1holdblock = true;
	if
	:: goto state37;
	:: goto state29;
	fi;
state29:
	bag1holdblock = true;
	goto state30;
state30:
	bag1holdblock = true;
	if
	:: goto state34;
	:: goto state31;
	fi;
state31:
	bag1holdblock = true;
	goto state32;
state32:
	bag1holdblock = false;
	goto state33;
state33:
	bag1holdblock = false;
	goto end_state6;
state34:
	bag1holdblock = false;
	goto state35;
state35:
	bag1holdblock = false;
	goto state36;
state36:
	bag1holdblock = false;
	goto end_state7;
state37:
	bag1holdblock = true;
	if
	:: goto state38;
	:: goto state31;
	fi;
state38:
	bag1holdblock = false;
	goto state35;
state39:
	bag1holdblock = true;
	goto state40;
state40:
	bag1holdblock = true;
	if
	:: goto state41;
	:: goto state44;
	fi;
state41:
	bag1holdblock = true;
	goto state42;
state42:
	bag1holdblock = false;
	goto state43;
state43:
	bag1holdblock = false;
	goto end_state8;
state44:
	bag1holdblock = false;
	goto state45;
state45:
	bag1holdblock = false;
	goto state46;
state46:
	bag1holdblock = false;
	goto end_state9;
state47:
	bag1holdblock = true;
	if
	:: goto state48;
	:: goto state60;
	fi;
state48:
	bag1holdblock = true;
	if
	:: goto state49;
	:: goto state56;
	fi;
state49:
	bag1holdblock = true;
	if
	:: goto state50;
	:: goto state53;
	fi;
state50:
	bag1holdblock = true;
	if
	:: goto state51;
	:: goto state52;
	fi;
state51:
	bag1holdblock = true;
	goto state8;
state52:
	bag1holdblock = false;
	goto state12;
state53:
	bag1holdblock = true;
	if
	:: goto state54;
	:: goto state55;
	fi;
state54:
	bag1holdblock = true;
	goto state20;
state55:
	bag1holdblock = false;
	goto state23;
state56:
	bag1holdblock = true;
	if
	:: goto state57;
	:: goto state41;
	fi;
state57:
	bag1holdblock = true;
	if
	:: goto state58;
	:: goto state59;
	fi;
state58:
	bag1holdblock = true;
	goto state32;
state59:
	bag1holdblock = false;
	goto state35;
state60:
	bag1holdblock = false;
	goto state61;
state61:
	bag1holdblock = false;
	if
	:: goto state67;
	:: goto state62;
	fi;
state62:
	bag1holdblock = false;
	if
	:: goto state65;
	:: goto state63;
	fi;
state63:
	bag1holdblock = false;
	if
	:: goto state64;
	:: goto state52;
	fi;
state64:
	bag1holdblock = false;
	goto state8;
state65:
	bag1holdblock = false;
	if
	:: goto state66;
	:: goto state55;
	fi;
state66:
	bag1holdblock = false;
	goto state20;
state67:
	bag1holdblock = false;
	if
	:: goto state68;
	:: goto state45;
	fi;
state68:
	bag1holdblock = false;
	if
	:: goto state69;
	:: goto state59;
	fi;
state69:
	bag1holdblock = false;
	goto state32;
state70:
	bag1holdblock = true;
	if
	:: goto state71;
	:: goto state124;
	fi;
state71:
	bag1holdblock = true;
	if
	:: goto state112;
	:: goto state72;
	fi;
state72:
	bag1holdblock = true;
	if
	:: goto state100;
	:: goto state73;
	fi;
state73:
	bag1holdblock = true;
	if
	:: goto state89;
	:: goto state74;
	fi;
state74:
	bag1holdblock = true;
	if
	:: goto state82;
	:: goto state75;
	fi;
state75:
	bag1holdblock = true;
	if
	:: goto state76;
	:: goto state79;
	fi;
state76:
	bag1holdblock = true;
	goto state77;
state77:
	bag1holdblock = false;
	goto state78;
state78:
	bag1holdblock = false;
	goto end_state10;
state79:
	bag1holdblock = false;
	goto state80;
state80:
	bag1holdblock = false;
	goto state81;
state81:
	bag1holdblock = false;
	goto end_state11;
state82:
	bag1holdblock = true;
	if
	:: goto state83;
	:: goto state86;
	fi;
state83:
	bag1holdblock = true;
	goto state84;
state84:
	bag1holdblock = false;
	goto state85;
state85:
	bag1holdblock = false;
	goto end_state12;
state86:
	bag1holdblock = false;
	goto state87;
state87:
	bag1holdblock = false;
	goto state88;
state88:
	bag1holdblock = false;
	goto end_state13;
state89:
	bag1holdblock = true;
	if
	:: goto state97;
	:: goto state90;
	fi;
state90:
	bag1holdblock = true;
	if
	:: goto state91;
	:: goto state94;
	fi;
state91:
	bag1holdblock = true;
	goto state92;
state92:
	bag1holdblock = false;
	goto state93;
state93:
	bag1holdblock = false;
	goto end_state14;
state94:
	bag1holdblock = false;
	goto state95;
state95:
	bag1holdblock = false;
	goto state96;
state96:
	bag1holdblock = false;
	goto end_state15;
state97:
	bag1holdblock = true;
	goto state98;
state98:
	bag1holdblock = false;
	goto state99;
state99:
	bag1holdblock = false;
	goto end_state16;
state100:
	bag1holdblock = false;
	goto state101;
state101:
	bag1holdblock = false;
	if
	:: goto state102;
	:: goto state107;
	fi;
state102:
	bag1holdblock = false;
	if
	:: goto state103;
	:: goto state105;
	fi;
state103:
	bag1holdblock = false;
	if
	:: goto state104;
	:: goto state79;
	fi;
state104:
	bag1holdblock = false;
	goto state77;
state105:
	bag1holdblock = false;
	if
	:: goto state86;
	:: goto state106;
	fi;
state106:
	bag1holdblock = false;
	goto state84;
state107:
	bag1holdblock = false;
	if
	:: goto state108;
	:: goto state110;
	fi;
state108:
	bag1holdblock = false;
	if
	:: goto state109;
	:: goto state94;
	fi;
state109:
	bag1holdblock = false;
	goto state92;
state110:
	bag1holdblock = false;
	goto state111;
state111:
	bag1holdblock = false;
	goto end_state17;
state112:
	bag1holdblock = false;
	goto state113;
state113:
	bag1holdblock = false;
	if
	:: goto state114;
	:: goto state100;
	fi;
state114:
	bag1holdblock = false;
	if
	:: goto state115;
	:: goto state120;
	fi;
state115:
	bag1holdblock = false;
	if
	:: goto state116;
	:: goto state118;
	fi;
state116:
	bag1holdblock = false;
	if
	:: goto state117;
	:: goto state79;
	fi;
state117:
	bag1holdblock = false;
	goto state77;
state118:
	bag1holdblock = false;
	if
	:: goto state86;
	:: goto state119;
	fi;
state119:
	bag1holdblock = false;
	goto state84;
state120:
	bag1holdblock = false;
	if
	:: goto state121;
	:: goto state123;
	fi;
state121:
	bag1holdblock = false;
	if
	:: goto state122;
	:: goto state94;
	fi;
state122:
	bag1holdblock = false;
	goto state92;
state123:
	bag1holdblock = false;
	goto state98;
state124:
	bag1holdblock = false;
	goto state125;
state125:
	bag1holdblock = false;
	if
	:: goto state112;
	:: goto state126;
	fi;
state126:
	bag1holdblock = false;
	if
	:: goto state100;
	:: goto state127;
	fi;
state127:
	bag1holdblock = false;
	if
	:: goto state128;
	:: goto state133;
	fi;
state128:
	bag1holdblock = false;
	if
	:: goto state129;
	:: goto state131;
	fi;
state129:
	bag1holdblock = false;
	if
	:: goto state130;
	:: goto state79;
	fi;
state130:
	bag1holdblock = false;
	goto state77;
state131:
	bag1holdblock = false;
	if
	:: goto state132;
	:: goto state86;
	fi;
state132:
	bag1holdblock = false;
	goto state84;
state133:
	bag1holdblock = false;
	if
	:: goto state134;
	:: goto state136;
	fi;
state134:
	bag1holdblock = false;
	if
	:: goto state135;
	:: goto state94;
	fi;
state135:
	bag1holdblock = false;
	goto state92;
state136:
	bag1holdblock = false;
	goto state98;
}