./fast-downward.sif --plan-file ${2}_output --alias lama-first $1 ${2} > /dev/null 2>&1

if [ -e ${2}_output ]; then
    cat ${2}_output #| sed '/^;/d; s/(\([^ _]*\)[^ ]*\ \([a-z0-9]*\).*/\1(\2)/g; s/\([pn][0-5]\)\([pn][0-5]\)/\1,\2/g; s/p//g; s/n\([0-5]\)/-\1/g' 
else
    echo "NO PLAN"
fi
