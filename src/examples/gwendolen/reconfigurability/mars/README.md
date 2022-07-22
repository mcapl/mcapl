# Reconfigurability framework used in the paper "Plan Library Reconfigurability in BDI Agents".

Paper: https://link.springer.com/chapter/10.1007/978-3-030-51417-4_10

Steps to run:
1. Download [MCAPL](https://autonomy-and-verification.github.io/tools/mcapl) using the Eclipse method, and make sure it is working properly (we only need AIL, you do not need test the verification using JPF)
2. Download [Fast-Downward](https://www.fast-downward.org/QuickStart) using the Apptainer method, and make sure it is working properly
3. Create a new folder in your MCAPL folder like this: `mcapl/src/examples/gwendolen/reconfigurability/mars`
4. Clone this repository into the folder you created on step 3
5. Move the Fast-Downward Apptainer image to the folder you created on step 3
6. In Eclipse, go to `rc/examples/gwendolen/reconfigurability/mars`, right-click mars.ail, select run as > run configurations, type run-AIL in the search box (should be there if MCAPL was installed correctly), and click on run
