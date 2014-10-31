package at.cinephilia.web.common.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.data.GetTheFuckingHash;
import at.cinephilia.web.common.service.CommonService;
import at.cinephilia.model.Contribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/common")
public class CommonContributeController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/contributes", method = RequestMethod.GET)
    public ModelAndView getContributes() throws IOException, NoSuchAlgorithmException {
        ModelAndView modelAndView = new ModelAndView("common");
        List<Contribute> contributes_id = commonService.contributeList();
        List<Contribute> contributes = getContributeFromJson(contributes_id);
        modelAndView.addObject("contributes", contributes);
        return modelAndView;
    }

    private List<Contribute> getContributeFromJson(List<Contribute> contributes_id) throws IOException, NoSuchAlgorithmException {
        List<Contribute> contributes = new ArrayList<>();
        Contribute contribute;
        String _ID;
        String participant_ID;
        String movie_ID;
        String diractor;
        for (JsonObject jsonObject : getContributeJsonArray().getValuesAs(JsonObject.class)) {

            participant_ID = jsonObject.getString("participant_ID");
            movie_ID = jsonObject.getString("movie_ID");
            diractor = jsonObject.getString("diractor");

            _ID = new GetTheFuckingHash().getAMd5Hash(participant_ID, movie_ID);

            if (contributes_id.contains(_ID)) {

            } else {
                contribute = new Contribute(_ID, participant_ID, movie_ID, diractor);
                commonService.addContributes(contribute);
                contributes.add(contribute);
            }
        }
        return contributes;
    }

    private JsonArray getContributeJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("contributes");
        return jsonArray;
    }

}
