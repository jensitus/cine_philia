package at.cinephilia.web.common.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.web.common.service.CommonService;
import at.cinephilia.web.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/common")
public class CommonParticipantController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/participants", method = RequestMethod.GET)
    public ModelAndView getParticipants() throws IOException {
        ModelAndView modelAndView = new ModelAndView("common");
        List<Participant> participants_id = commonService.participantList();
        List<Participant> participants = getParticipantFromJson(participants_id);
        modelAndView.addObject("participants", participants);
        return modelAndView;
    }

    private List<Participant> getParticipantFromJson(List<Participant> participants_id) throws IOException {
        List<Participant> participants = new ArrayList<>();
        Participant participant;
        String name;
        String _ID;
        for (JsonObject jsonObject : getParticipantJsonArray().getValuesAs(JsonObject.class)) {
            name = jsonObject.getString("name");
            _ID = jsonObject.getString("_ID");
            if (participants_id.contains(_ID)) {

            } else {
                participant = new Participant(name, _ID);
                commonService.addParticipant(participant);
                participants.add(participant);
            }
        }
        return participants;
    }

    private JsonArray getParticipantJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("participants");
        return jsonArray;
    }

}
