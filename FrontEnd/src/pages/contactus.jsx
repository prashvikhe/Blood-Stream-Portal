import { Grid, Typography, Divider } from "@material-ui/core";
import CallIcon from '@mui/icons-material/Call';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import EmailIcon from '@mui/icons-material/Email';


const ContactUs = (props) => {
  return (
    <div>
      <Typography variant="h3">
        Contact Us
      </Typography>
      <br />
      <Divider />
      <br />
      <br />
      <Grid container spacing={2} justifyContent={"space-around"}>
        <Grid item xs={12} sm={4}>
          <Typography mt={10} variant="h6" align="center">
            <LocationOnIcon fontSize="large" />
            <div><b>LOCATION</b></div> <br />
            <div> OFFICE 1 : Near Akurdi Railway Station<br /> Pune,Maharashtra<br /> 411012</div>
            <div> OFFICE 2 : PMT Hospital <br /> Loni,Maharashtra<br /> 413736</div>
          </Typography>
        </Grid>
        <Grid item xs={12} sm={4}>
          <Typography mt={10} variant="h6" align="center">
            <CallIcon fontSize="large" />
            <div><b>PHONE NUMBER</b></div> <br />
            <div>OFFICE 1 : <br /> +91 &nbsp; 8796012294 <br /> +91 &nbsp;8208700986</div>
            <div>OFFICE 2 : <br /> +91 &nbsp;9370501455 <br /> +91 &nbsp;9960027595</div>
          </Typography>
        </Grid>
        <Grid item xs={12} sm={4}>
          <Typography mt={10} variant="h6" align="center">
            <EmailIcon fontSize="large" />
            <div><b>EMAIL</b></div> <br />
            <div>bloodstream2023@gmail.com <br /> </div>
          </Typography>
        </Grid>
      </Grid>





    </div>
  );
};

export default ContactUs;