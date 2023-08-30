import { orange, indigo, red } from "@material-ui/core/colors";
import createPalette from "@material-ui/core/styles/createPalette";

const darkTheme = createPalette({
  primary: {
    light: red[300],
    main: red[500],
    dark: red[700]
  },
  secondary: {
    light: orange[300],
    main: orange[500],
    dark: orange[700]
  },
  type: "dark"
});

const lightTheme = createPalette({
  primary: {
    light: red[300],
    main: red[500],
    dark: red[700]
  },
  secondary: {
    light: indigo[300],
    main: indigo[500],
    dark: indigo[700]
  },
  type: "light"
});

export { darkTheme, lightTheme };
